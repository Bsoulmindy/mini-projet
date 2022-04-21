$('.js-ajouterOrigine-hide').on('click' ,function(e){
    $('.js-ajouterOrigine-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});
$('.btn-ajouterOrigine').on('click' ,function(e){
	$('.js-ajouterOrigine-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});


function getContenu() 
{
    var xhr = new XMLHttpRequest();
	xhr.open('GET', '/admin/getAllOrigine');
	xhr.timeout = 10000;
	xhr.onload = function () {
		if(xhr.status == 200)
		{
			$('#contenu').html(xhr.responseText);
		}
            
	}
	xhr.send();
}

function ajouterOrigine(event) {
	event.preventDefault()
	event.stopPropagation()
	const nom = document.getElementById("ajouterOrigineNom");

	const newOrigineMessage = document.getElementById("newOrigineMessage");

	// Traitement des données
	const divTimeout = '<div class="alert alert-danger" role="alert">Connexion échoué avec le serveur, veuillez réssayer! </div>';

    let produitForm = new FormData();
    produitForm.append("nom", nom.value);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/admin/newOrigine');
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        newOrigineMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
            $('.js-ajouterOrigine-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
        }
		if(xhr.status == 400)
			newOrigineMessage.innerHTML = '<div class="alert alert-danger" role="alert">'+ xhr.responseText + '</div>';
		if(xhr.status > 400)
			newOrigineMessage.innerHTML = divTimeout;
	}
	xhr.send(produitForm);
}

getContenu();