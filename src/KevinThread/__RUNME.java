package KevinThread;

import java.util.Properties;

import org.encog.ml.data.temporal.TemporalMLDataSet;

import DataIngester.DataIngester;
import PropsXML.Props;

public class __RUNME {

	/*
	 * These are the only settings for this file. All other settings are specified in the properties
	 * file in this directory. The file must be in the root of the workingDir and be named
	 * as described in PROPS_FILE.
	 */
	final static String WORKING_DIR = "./data/EncogFiles/PropertiesTest"; // no backslash
	final static String PROPS_FILE = "config.xml";
	final static boolean printPropsDebugToConsole = true; // required because props are not loaded

	public static void main(String[] args) throws Exception {

		// load properties file and required values
		Properties props = Props.LoadProps(printPropsDebugToConsole, WORKING_DIR, PROPS_FILE);
		// debug printing
		int DEBUG_LEVEL = Props.GetInt(props, "DEBUG_LEVEL");
		// data files
		String[] DATA_FILES = Props.GetArrayOfStrings(printPropsDebugToConsole, props,
				"DATA_FILE_");
		// temporal settings
		int INPUT_WINDOW_SIZE = Props.GetInt(props, "INPUT_WINDOW_SIZE");
		int PREDICT_WINDOW_SIZE = Props.GetInt(props, "PREDICT_WINDOW_SIZE");
		// training
		String ACTIVATION_FUNCTION = Props.GetString(props, "ACTIVATION_FUNCTION");
		// predict
		int EVALUATE_START = Props.GetInt(props, "EVALUATE_START");
		int EVALUATE_END = Props.GetInt(props, "EVALUATE_END");

		// get data, then train and evaluate the neural network
		try {
			// Step 1. Create training data
			DataIngester dataIngester = new DataIngester();
			dataIngester.createData(DEBUG_LEVEL, DATA_FILES);

			TemporalMLDataSet temporalDataset = dataIngester.makeTemporalDataSet(DEBUG_LEVEL,
					INPUT_WINDOW_SIZE, PREDICT_WINDOW_SIZE);

//			// Step 2. Create and train the model.
//			MLRegression model = Train.trainModel(temporalDataset, MLMethodFactory.TYPE_FEEDFORWARD,
//					ACTIVATION_FUNCTION, MLTrainFactory.TYPE_RPROP, "");
//
//			// Step 3. Predict
//			Predict.predict(model, EVALUATE_START, EVALUATE_END, INPUT_WINDOW_SIZE);
//			
//			// shutdown
//			Encog.getInstance().shutdown();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}