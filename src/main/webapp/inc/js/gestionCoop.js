$('btn-accepterCoop').on('click' , gererDemandeCoop($(this), true))
$('btn-refuserCoop').on('click' , gererDemandeCoop($(this), false))

function getContenu() 
{
    var xhr = new XMLHttpRequest();
	xhr.open('GET', '/admin/getDemandesCooperatives');
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
			$('btn-accepterCoop').on('click' , gererDemandeCoop($(this), true))
            $('btn-refuserCoop').on('click' , gererDemandeCoop($(this), false))
		}
            
	}
	xhr.send();
}

function gererDemandeCoop(button, isAccepted)
{
    var xhr = new XMLHttpRequest();
    let form = new FormData();
	form.append("idCooperative", button.attr('idCooperative'));
	form.append("isAccepted", isAccepted);

	xhr.open('POST', "/admin/gererDemandeCoop");
	xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(form);
}

getContenu();