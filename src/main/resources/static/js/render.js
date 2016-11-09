
var renderClient = function (users) {
    ReactDOM.render(
        React.createElement(UserBox, {users: users || []}),
        document.getElementById("content")
    );
};

var renderServer = function (template, model) {
	// convert Java Objects to JSON string
	var ObjectMapper = Java.type("com.fasterxml.jackson.databind.ObjectMapper");
	var om = new ObjectMapper();
	var jsonString = om.writeValueAsString(model);
		
	//parse json string to get a real javascript object
	var jsonObject = JSON.parse(jsonString);
	
	// render the ejs template
    return ejs.render(template, jsonObject);
};