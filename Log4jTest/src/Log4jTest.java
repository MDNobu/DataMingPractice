import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


public class Log4jTest {
	
	static Logger logger = Logger.getLogger(Log4jTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender  = null;
		try {
			appender = new FileAppender(layout, "output1.txt", false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.addAppender(appender);
		logger.setLevel(Level.INFO);
		logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");   
		logger.debug("This is an add line");
	}

}
