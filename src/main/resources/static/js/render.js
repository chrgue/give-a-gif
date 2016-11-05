
var renderClient = function (users) {
    ReactDOM.render(
        React.createElement(UserBox, {users: users || []}),
        document.getElementById("content")
    );
};

var renderServer = function (users) {
	var data = Java.from(users);
    return ReactDOMServer.renderToString(
        React.createElement(UserBox, {users: data || []})
    );
};