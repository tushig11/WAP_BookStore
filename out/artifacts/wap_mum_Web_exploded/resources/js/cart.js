$(function(){
    $('.like-btn').on('click', function() {
        $(this).toggleClass('is-active');
    });

    $('.minus-btn').on('click', function(e) {
        e.preventDefault();
        let $this = $(this);
        let $input = $this.closest('div').find('input');
        let value = parseInt($input.val());

        if (value > 1) {
            value = value - 1;
        } else {
            value = 1;
        }

        $input.val(value);

    });

    $('.plus-btn').on('click', function(e) {
        e.preventDefault();
        let $this = $(this);
        let $input = $this.closest('div').find('input');
        let value = parseInt($input.val());

        if (value < 100) {
            value = value + 1;
        } else {
            value = 100;
        }

        $input.val(value);
    });
})
