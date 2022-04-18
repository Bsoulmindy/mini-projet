function getProduits(path)
{
    var xhr = new XMLHttpRequest();
    xhr.open('GET', path, false);
    xhr.onload = function() {
        if(xhr.status == 200)
            $('#sectionProducts').html(xhr.responseText);
    }
    xhr.send();
}

$('.category').on('click' ,function(e){
    e.preventDefault();
    getProduits($(this).attr('href'));
});
$('.matierePremiere').on('click' ,function(e){
    e.preventDefault();
    getProduits($(this).attr('href'));
});
$('.origine').on('click' ,function(e){
    e.preventDefault();
    getProduits($(this).attr('href'));
});

getProduits('/category/get/all');