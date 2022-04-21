$('.js-ajouterMP-hide').on('click' ,function(e){
    $('.js-ajouterMP-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});
$('.btn-ajouterMP').on('click' ,function(e){
	$('.js-ajouterMP-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});


function getContenu() 
{
    var xhr = new XMLHttpRequest();
	xhr.open('GET', '/admin/getAllMP');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.onload = function () {
		if(xhr.status == 200)
		{
			$('#contenu').html(xhr.responseText);
		}
            
	}
	xhr.send();
}

function ajouterMP(event) {
	event.preventDefault()
	event.stopPropagation()
	const nom = document.getElementById("ajouterMPNom");

	const newMPMessage = document.getElementById("ajouterMPMessage");

	// Traitement des données
	const divTimeout = '<div class="alert alert-danger" role="alert">Connexion échoué avec le serveur, veuillez réssayer! </div>';

    let produitForm = new FormData();
    produitForm.append("nom", nom.value);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/admin/newMP');
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        newMPMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
            $('.js-ajouterMP-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
        }
		if(xhr.status == 400)
			newMPMessage.innerHTML = '<div class="alert alert-danger" role="alert">'+ xhr.responseText + '</div>';
		if(xhr.status > 400)
			newMPMessage.innerHTML = divTimeout;
	}
	xhr.send(produitForm);
}

getContenu();