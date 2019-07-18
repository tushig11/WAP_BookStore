$(function () {
    //menu sticker
    $(window).scroll(stickyMenu);

    //read all data from db
    readAllData();

    //filter handler priceRange, categories, search
    //slider handler
    slider();
    //checkbox handler
    selectCategory();
    //search box handler
    $('#searchBtn').click(searchData);

});

function stickyMenu(){
    if ($(window).scrollTop() > 270) {
        $('#myMenu').addClass('sticky');
    } else {
        $('#myMenu').removeClass('sticky');
    }
}

//AJAX SECTION

//READ ALL DATA FROM DB ON HOME PAGE
//attach buttons to event
function addtoCart(){
    $(".addCart").click(function(event){
        event.stopPropagation();
        event.stopImmediatePropagation();
        let id = $(this).attr('id');
        let url = 'addToCart?id='+id;
        $.get(url, setCardValue);
    });
}

function setCardValue(data){
    console.log(data);
    $('#cardValue').html(data);
}

function readAllData(){
    $.get('ajax_all', allData).done(addtoCart);
}

function allData(data){
    let products = JSON.parse(data);
    contentClear();
    availableTags=[];
    for(let p of products){
        let productView = "<div class='card'>" +
            "<div class='image'>" + "<img src='resources/images"+ p.picturePath +"' alt='"+p.name+"'/></div>" +
            "<div class='details'>" +
            "<div class='center'>" +
            "<h1>"+p.name+"<br><span class='author'>"+p.author+"</span></h1>" +
            "<p class='category'>"+p.category+"</p>" +
            "<p>Price: <strong>"+p.price+"$</strong></p>" +
            "<button class='addCart' id='"+p.id+"'>Add to cart</button>" +
            "</div>"+
            "</div>"+
            "</div>";
        $('#content').append(productView);
        availableTags.push(p.name);
    }

    //auto complete on search box
    $( "#searchTxt" ).autocomplete({
        source: availableTags
    });
}

//SEARCH BOX AJAX HANDLER

function searchData(){
    let searchValue = $('#searchTxt').val();
    let url = 'searchByText?text='+searchValue;
    $.get(url, callbackData).done(addtoCart);
}

//PRICE RANGE FILTER EVENT HANDLER
function slider(){
    let slider = $('#myRange');
    let output = $('#priceRange');
    output.html(slider.val()+"$");
    slider.on('input', function() {
        output.html(slider.val()+"$");
        let url = 'search?price='+slider.val();
        $.get(url, callbackData).done(addtoCart);
    });
}


//FILTERED DATA
function callbackData(data){
    let products = JSON.parse(data);
    contentClear();
    for(let p of products){
        let productView = "<div class='card'>" +
            "<div class='image'>" + "<img src='resources/images"+ p.picturePath +"' alt='"+p.name+"'/></div>" +
            "<div class='details'>" +
            "<div class='center'>" +
            "<h1>"+p.name+"<br><span class='author'>"+p.author+"</span></h1>" +
            "<p class='category'>"+p.category+"</p>" +
            "<p>Price: <strong>"+p.price+"$</strong></p>" +
            "<button class='addCart' id='"+p.id+"'>Add to cart</button>" +
            "</div>"+
            "</div>"+
            "</div>";
        $('#content').append(productView);
    }
}

function selectCategory(){
    var category = [false,false,false,false];

    $('#bio').click(function(){
        let value = $(this).is(':checked');
        category[0] = value;
        $.post('search',{categories: JSON.stringify(category)}, postData, "json").done(addtoCart);
    });
    $('#bus').click(function(){
        let value = $(this).is(':checked');
        category[1] = value;
        $.post('search',{categories: JSON.stringify(category)}, postData, "json").done(addtoCart);
    });
    $('#his').click(function(){
        let value = $(this).is(':checked');
        category[2] = value;
        $.post('search',{categories: JSON.stringify(category)}, postData, "json").done(addtoCart);
    });
    $('#mys').click(function(){
        let value = $(this).is(':checked');
        category[3] = value;
        $.post('search',{categories: JSON.stringify(category)}, postData, "json").done(addtoCart);
    });
}

//FILTERED DATA
function postData(data){
    contentClear();
    for(let p of data){
        let productView = "<div class='card'>" +
            "<div class='image'>" + "<img src='resources/images"+ p.picturePath +"' alt='"+p.name+"'/></div>" +
            "<div class='details'>" +
            "<div class='center'>" +
            "<h1>"+p.name+"<br><span class='author'>"+p.author+"</span></h1>" +
            "<p class='category'>"+p.category+"</p>" +
            "<p>Price: <strong>"+p.price+"$</strong></p>" +
            "<button class='addCart' id='"+p.id+"'>Add to cart</button>" +
            "</div>"+
            "</div>"+
            "</div>";
        $('#content').append(productView);
    }
}

//content clear
function contentClear(){
    $('#content').html("");
}

//flips random product





