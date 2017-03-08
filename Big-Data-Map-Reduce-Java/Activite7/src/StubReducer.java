import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class StubReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {

double sum=0;
int nb=0;
OutputCollector<Text, DoubleWritable> output;


@Override
public void reduce(Text key, Iterator<DoubleWritable> values,
		OutputCollector<Text, DoubleWritable> output, Reporter arg3)
		throws IOException {

	 
	  double x=0;
	  while(values.hasNext())
	  {   x=values.next().get();
		  sum+=x*Double.parseDouble(key.toString());
		  nb+=x;
				  
	  }
	  
	  this.output=output;
}

@Override
public void close()
{
	
	
	
			try {
				output.collect(new Text(Integer.toString(nb)), new DoubleWritable(sum) );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}


