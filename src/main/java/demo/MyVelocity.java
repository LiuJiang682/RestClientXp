package demo;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;

public class MyVelocity {

	private static final Logger LOGGER = Logger.getLogger(MyVelocity.class);

	private String name;

	public MyVelocity() {
		Velocity.setProperty("runtime.log.logsystem.log4j.logger", "root");
		// File f = new File("f");
		// System.err.println(f.getAbsolutePath());
		Velocity.setProperty("file.resource.loader.path",
				"src/main/resources/static");
		Velocity.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE, IncludeRelativePath.class.getName());
		/*
		 * Configure the engine - as an example, we are using ourselves as the
		 * logger - see logging examples
		 */

		// Velocity.setProperty(
		// Velocity.RUNTIME_LOG_LOGSYSTEM, this);

		/*
		 * now initialize the engine
		 */

		Velocity.init();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVelocityName() {
		/* lets make a Context and put data into it */

		VelocityContext context = new VelocityContext();

//		context.put("name", name);
		context.put("some", name);
		context.put("project", "Jakarta");
		ArrayList<String> somelist = new ArrayList<>();
		somelist.add("Hello");
		context.put("somelist", somelist );

		/* lets render a template */

		StringWriter w = new StringWriter();

		// Velocity.mergeTemplate("test.vm", context, w );
		Template t = Velocity.getTemplate("main.vm");
		t.merge(context, w);
		LOGGER.info(w);
		return w.toString();

		/* lets make our own string to render */

		// String s = "We are using $project $name to render this.";
		// w = new StringWriter();
		// Velocity.evaluate( context, w, "mystring", s );
	}
}
