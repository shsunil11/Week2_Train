import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


   public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
      final private static LongWritable ONE = new LongWritable(1);
      private Text tokenValue = new Text();

      @Override
      protected void map(LongWritable offset, Text text, Context context) throws IOException, InterruptedException {
         for (String token : text.toString().split("\\s+")) {
            tokenValue.set(token);
            context.write(tokenValue, ONE);
         }
      }
   }
