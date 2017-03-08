import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reporter;

public class StubMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {

	

	 


@Override
public void map(LongWritable key, Text value,
		OutputCollector<Text, DoubleWritable> output, Reporter arg3)
		throws IOException {
	
		String[] itr= value.toString().split("\t");
		int i=2;
	    
		
		
		while(i<itr.length)
			{
		  
		
		    output.collect(new Text(itr[i]),new DoubleWritable(Double.parseDouble(itr[i+2])));
			i+=5;
			}
	  
}
}
