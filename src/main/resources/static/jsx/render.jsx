var renderClient = function (initialState) {
	
    ReactDOM.render(
    	<App users={initialState.users}/>,
        document.getElementById("content")
    );
};