import ReactDOM from 'react-dom';
import React from 'react';
import {App} from './components/App.jsx'
import $ from 'jquery';

var renderClient = function (initialState) {
	
    ReactDOM.render(
    	<App data={initialState}/>,
        document.getElementById("content")
    );
};

$(function() {
	renderClient(window.INITIAL_DATA || {});
});