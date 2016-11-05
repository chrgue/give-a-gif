package com.chrgue.nashorn.react;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import jdk.nashorn.api.scripting.NashornScriptEngine;

@Service
public class ReactService {

	
	private ThreadLocal<NashornScriptEngine> engineHolder = new ThreadLocal<NashornScriptEngine>() {
        @Override
        protected NashornScriptEngine initialValue() {
            NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
            try {
            	nashornScriptEngine.eval(read("META-INF/resources/webjars/react/15.3.1/react.min.js"));
            	nashornScriptEngine.eval(read("META-INF/resources/webjars/react/15.3.1/react-dom-server.min.js"));
            	nashornScriptEngine.eval(read("static/js/polyfill.js"));
            	nashornScriptEngine.eval(read("static/js/render.js"));
            	nashornScriptEngine.eval(read("static/js/UserBox.js"));
            	
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
            return nashornScriptEngine;
        }
    };

    public  String renderUserBox(List<String> users) {
        try {
            Object html = engineHolder.get().invokeFunction("renderServer", users);
            return String.valueOf(html);
        }
        catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }

    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
