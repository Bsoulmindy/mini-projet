function connecter(event) {
	event.preventDefault()
	event.stopPropagation()
	const username = document.getElementById("lusername");
	const password = document.getElementById("lpassword");
	const statusDiv = document.getElementById("statusDiv");
	


	// Traitement des données

	let compteForm = {
		username: username.value,
		password: password.value
	}

	console.log(compteForm);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/connexion');
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.timeout = 5000;
	xhr.ontimeout = function () {
        console.log("timeout!")
    };
	xhr.onload = function () {
		if(xhr.status == 200)
        {
            token = JSON.parse(xhr.responseText);
            document.cookie = "jwtToken="+token.token;
			window.location.replace("/");
        }
		else
		{
			statusDiv.innerHTML = '<div class="alert danger" style="color: white" role="alert">Connexion échoué</div>';
		}
	}
	xhr.send(JSON.stringify(compteForm));
	
}