import ReactDOM from 'react-dom';
import React from 'react';
import {App} from './components/App.jsx'

// loads the bootstrap js
import 'bootstrap';
// loads the bootstrap css
import 'bootstrap/dist/css/bootstrap.css';

var renderClient = function (initialState) {
    ReactDOM.render(
    	<App data={initialState}/>,
        document.getElementById("content")
    );
};

$(function() {
	renderClient(window.INITIAL_DATA || {});
});