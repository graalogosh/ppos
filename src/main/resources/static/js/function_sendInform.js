//функция формирова объектов для их отправки запросом ajax
function sendInform () {
	//создаем объект
	var object = {};

	//формируем поля объекта в соответствии с переданными параметрами 
	//(переданный параметр - имя поля, значение поля - содержимое value выбранного элемента)
	for (var i = 0; i < arguments.length; i++) {
		//проверяет, не является ли элемент checkbox'ом. Если не является, то записываем value выбранного элемента
		if ($("#" + arguments[i]).attr("type") != "checkbox")
		{
			object[arguments[i]] = $("#" + arguments[i]).val();
		}
		//если элемент является checkbox'ом, то записываем в содержимое поля, нажат он или нет
		else {
			object[arguments[i]] = $("#" + arguments[i]).is(":checked");
		}
	}
	return object;
}
