//функция формирова объектов для их отправки запросом ajax
function sendInform () {
	//создаем объект
	var object = {};

	//формируем поля объекта в соответствии с переданными параметрами 
	//(переданный параметр - имя поля, значение поля - содержимое элемента с таким именем)
	for (var i = 0; i < arguments.length; i++) {
		object[arguments[i]] = $("#" + arguments[i]).val();
	}
	return object;
}
