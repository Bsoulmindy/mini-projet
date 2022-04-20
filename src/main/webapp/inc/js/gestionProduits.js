$('.js-ajouterProduit-hide').on('click' ,function(e){
    $('.js-ajouterProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});
$('.js-modifierProduit-hide').on('click' ,function(e){
    $('.js-modifierProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
});

$('btn-toggleCommande').on('change' , toggleCommande($(this)))


function getContenu() 
{
    var xhr = new XMLHttpRequest();
	xhr.open('GET', '/cooperative/produit/getAll');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        newProduitMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
		{
			$('#contenu').html(xhr.responseText);
			$('.btn-ajouterProduit').on('click' ,function(e){
				$('.js-ajouterProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
			});
			$('.btn-modifierProduit').on('click' ,function(e){
				$('.js-modifierProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
				$('#idProduit').attr('value', $(this).attr('value'));
			});
			$('.btn-supprimerProduit').on('click' ,function(e){
				supprimerProduit($(this).attr('value'));
			});
			$('.btn-associerProduit').on('click' ,function(e){
				$('.js-associerProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
				$('#idProduit2').attr('value', $(this).attr('value'));
			});
		}
            
	}
	xhr.send();
}

function ajouterProduit(event) {
	event.preventDefault()
	event.stopPropagation()
	const nom = document.getElementById("newProduitNom");
	const image = document.getElementById("newProduitImage");
	const unite = document.getElementById("newProduitUnite");
	const prix = document.getElementById("newProduitPrix");
    const categorie = document.getElementById("newProduitCategorie");

	const newProduitMessage = document.getElementById("newProduitMessage");

	// Traitement des données
	const divLoading = '<img src="/inc/images/loader.gif">';
	const divTimeout = '<div class="alert alert-danger" role="alert">Connexion échoué avec le serveur, veuillez réssayer! </div>';

	if(image.files.length == 0) newProduitMessage.innerHTML = '<div class="alert alert-danger" role="alert">Image est obligatoire</div>';

    let produitForm = new FormData();
    produitForm.append("nom", nom.value);
    produitForm.append("image", image.files[0]);
    produitForm.append("unite", unite.value);
    produitForm.append("prix", prix.value);
    produitForm.append("categorie", categorie.value);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/cooperative/produit/new');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        newProduitMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
            $('.js-ajouterProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
        }
		if(xhr.status == 400)
			newProduitMessage.innerHTML = '<div class="alert alert-danger" role="alert">'+ xhr.responseText + '</div>';
		if(xhr.status > 400)
			newProduitMessage.innerHTML = divTimeout;
	}
	xhr.send(produitForm);
}

function modifierProduit(event) {
	event.preventDefault()
	event.stopPropagation()
	const nom = document.getElementById("modifierProduitNom");
	const image = document.getElementById("modifierProduitImage");
	const unite = document.getElementById("modifierProduitUnite");
	const prix = document.getElementById("modifierProduitPrix");
    const categorie = document.getElementById("modifierProduitCategorie");
	const idProduit = document.getElementById("idProduit");

	const modifierProduitMessage = document.getElementById("modifierProduitMessage");

	// Traitement des données
	const divLoading = '<img src="/inc/images/loader.gif">';
	const divTimeout = '<div class="alert alert-danger" role="alert">Connexion échoué avec le serveur, veuillez réssayer! </div>';

    let produitForm = new FormData();
    produitForm.append("nom", nom.value);
    produitForm.append("image", image.files[0]);
    produitForm.append("unite", unite.value);
    produitForm.append("prix", prix.value);
    produitForm.append("categorie", categorie.value);
	produitForm.append("idProduit", idProduit.value);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/cooperative/produit/update');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        modifierProduitMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
            $('.js-ajouterProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
        }
		if(xhr.status == 400)
			modifierProduitMessage.innerHTML = '<div class="alert alert-danger" role="alert">'+ xhr.responseText + '</div>';
		if(xhr.status > 400)
			modifierProduitMessage.innerHTML = divTimeout;
	}
	xhr.send(produitForm);
}

function supprimerProduit(id)
{
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/cooperative/produit/delete');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
        }
	}
	xhr.send(id);
}

function associerProduit(event) {
	event.preventDefault()
	event.stopPropagation()
    const MP = document.getElementById("newProduitMatierePremiere");
	const origine = document.getElementById("newProduitOrigine");
	const idProduit = document.getElementById("idProduit2");


	const newProduitMessage = document.getElementById("associerProduitMessage");

	// Traitement des données
	const divLoading = '<img src="/inc/images/loader.gif">';
	const divTimeout = '<div class="alert alert-danger" role="alert">Connexion échoué avec le serveur, veuillez réssayer! </div>';

    let produitForm = new FormData();
    produitForm.append("idMatierePremiere", MP.value);
	produitForm.append("idOrigine", origine.value);
	produitForm.append("idProduit", idProduit.value);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/cooperative/produit/associate');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 10000;
	xhr.ontimeout = function () {
        newProduitMessage.innerHTML = divTimeout;
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            getContenu();
            $('.js-ajouterProduit-form').toggleClass('is-shown--off-flow').toggleClass('is-hidden--off-flow');
        }
		if(xhr.status == 400)
			newProduitMessage.innerHTML = '<div class="alert alert-danger" role="alert">'+ xhr.responseText + '</div>';
		if(xhr.status > 400)
			newProduitMessage.innerHTML = divTimeout;
	}
	xhr.send(produitForm);
}

function toggleCommande(checkbox)
{
	var xhr = new XMLHttpRequest();
	let form = new FormData();
	form.append("idCommande", checkbox.attr('idCommande'));
	form.append("toggle", checkbox.is(":checked"));

	xhr.open('POST', '/cooperative/commande/toggle');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(form);
}

getContenu();