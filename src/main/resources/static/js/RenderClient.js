
var renderClient = function (users) {
    ReactDOM.render(
        React.createElement(UserBox, {users: users || []}),
        document.getElementById("content")
    );
};