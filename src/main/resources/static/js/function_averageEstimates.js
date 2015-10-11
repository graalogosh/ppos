<!-- Функция для вычисления средней оценки студента. В качестве параметра подаётся id элемента (без символа "#"), в котором в строковом виде хранятся оценки. -->
function averageEstimates (input) {

	<!-- Переменная для хранения среднего зачения по оценкам. -->
	var averageEstimates = 0;

	<!-- Переменная, в которую записываем строку с оценками из выбранного элемента -->
	var stringEstimates = $("#"+input).val();

	for (var i = 0; i < stringEstimates.length; i++) {
		<!-- Применяем унарный + для преобразования символа stringEstimates[i] в число  -->
		averageEstimates = averageEstimates + +stringEstimates[i]
	};

	averageEstimates = averageEstimates/stringEstimates.length;

	return averageEstimates;
}