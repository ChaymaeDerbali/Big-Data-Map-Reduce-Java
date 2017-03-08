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

HashMap<String, Double> map=new HashMap<String, Double>();
OutputCollector<Text, DoubleWritable> output;


@Override
public void reduce(Text key, Iterator<DoubleWritable> values,
		OutputCollector<Text, DoubleWritable> output, Reporter arg3)
		throws IOException {
	  this.output=output;
	
          
	  double sum=0;
	  while(values.hasNext())
	  {
		  sum+=values.next().get();
	  }
      if((key.toString().equals("TOYS"))|| key.toString().equals("CONSUMER ELECTRONICS"))
    	  map.put(key.toString(), sum);
	      output.collect(key, new DoubleWritable(sum));
      
      
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