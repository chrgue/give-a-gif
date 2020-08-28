import ReactDOMServer from 'react-dom/server'
import React from 'react';
import {App} from './components/App.jsx';


global.renderServer = function(template, javaModel) {
	// convert Java Objects to JSON string
	var json = toJsonObject(javaModel);

	// render app & ejs template
	var renderedHTML = ReactDOMServer.renderToString(React.createElement(App,{data:json}))
    return ejs.render(template, {renderedHTML : renderedHTML, state: JSON.stringify(json)});
}

function toJsonObject(model) {
	var o = {};
	for (var k in model) {
		// Convert Iterable like List to real JSON array
		if (model[k] instanceof Java.type("java.lang.Iterable")) {
			o[k] = Java.from(model[k]);
		}
		else {
			o[k] = model[k];
		}
	}
	return o;
}
