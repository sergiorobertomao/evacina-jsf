function somar(){
	var valor1 = parseFloat(document.getElementById('valor1').value);
	var valor2 = parseFloat(document.getElementById('valor2').value);
	var resultado = valor1 + valor2;
	document.getElementById('resultado').value = resultado;
}

function subtrair(){
	var valor1 = parseFloat(document.getElementById('valor1').value);
	var valor2 = parseFloat(document.getElementById('valor2').value);
	var resultado = valor1 - valor2;
	document.getElementById('resultado').value = resultado;
}

function multiplicar(){
	var valor1 = parseFloat(document.getElementById('valor1').value);
	var valor2 = parseFloat(document.getElementById('valor2').value);
	var resultado = valor1 * valor2;
	document.getElementById('resultado').value = resultado;
}

function dividir(){
	var valor1 = parseFloat(document.getElementById('valor1').value);
	var valor2 = parseFloat(document.getElementById('valor2').value);
	var resultado = valor1 / valor2;
	document.getElementById('resultado').value = resultado;
}

function verificarvazio(){
		alert("Valor 1 - Campo Vazio !");
		document.getElementById('valor1').focus();
	}


function verificarVaziox(){
	if(document.getElementById('valor1').value == "1"){
		alert("Valor 1 - Campo Vazio !");
		document.getElementById('valor1').focus();
		return false
	}
}