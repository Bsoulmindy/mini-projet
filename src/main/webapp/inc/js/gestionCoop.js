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
			$('.btn-accepterCoop').on('click' , {isAccepted: true}, gererDemandeCoop)
            $('.btn-refuserCoop').on('click' , {isAccepted: false}, gererDemandeCoop)
		}
            
	}
	xhr.send();
}

function gererDemandeCoop(e)
{
    var xhr = new XMLHttpRequest();
    let form = new FormData();
	form.append("idCooperative", this['value']);
	form.append("isAccepted", e.data.isAccepted);
	xhr.open('POST', "/admin/gererDemandeCoop");

	xhr.onload = function () {
		if(xhr.status == 200)
		{
			getContenu();
		}
	}
	xhr.send(form);
}

getContenu();