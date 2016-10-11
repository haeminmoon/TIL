package IO_Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BufferedStream{
	
	protected BufferedReader br;
	protected BufferedWriter bw;
	
	public BufferedStream() {
		br = null;
		bw = null;
	}
	
	//randomMaker_num
	//randomMake_str
	
	public abstract List<Object> getInputList();
	public abstract void setOutput(List<Object> resultList);
}