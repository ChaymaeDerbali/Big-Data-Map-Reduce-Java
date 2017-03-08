import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class StubReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {

HashMap<String, Double> map=new HashMap<String, Double>();;
OutputCollector<Text, DoubleWritable> output;



@Override
public void reduce(Text key, Iterator<DoubleWritable> values,
		OutputCollector<Text, DoubleWritable> output, Reporter arg3)
		throws IOException {
       this.output=output;
     
	  
      double max=-1000;
	  double x;
      while(values.hasNext())
	  {   x=values.next().get();
    	  if(x>max)
		  max=x;
	  }
      if((key.toString().equals("RENO"))|| key.toString().equals("CHANDLER")||(key.toString().equals("TOLEDO")))
    	  map.put(key.toString(), max);
	      output.collect(key, new DoubleWritable(max));
      
	      
	     
	      
}

@Override
public void close()
{
	for(Entry<String,Double> entry : map.entrySet())
	{
	      try {
			output.collect(new Text(entry.getKey()), new DoubleWritable(entry.getValue()));
		} catch (IOException e) {
			e.printStackTrace();
		}
 	
	}
}


}