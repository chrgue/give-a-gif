import ReactDOMServer from 'react-dom/server'
import React from 'react';
import {App} from './components/App.jsx';


global.renderServer = function(template, model) {
	// convert Java Objects to JSON string
	var ObjectMapper = Java.type("com.fasterxml.jackson.databind.ObjectMapper");
	var om = new ObjectMapper();
	var json = om.writeValueAsString(model);
	
	// render the ejs template
    return ejs.render(template, {data:json, ReactDOMServer:ReactDOMServer, App:App, React:React});
}
