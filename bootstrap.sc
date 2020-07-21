import $ivy.`org.apache.spark::spark-sql:2.4.4`
import $ivy.`sh.almond::ammonite-spark:0.10.0`
import $ivy.`io.projectglow:glow_2.12:0.5.0`
import $ivy.`net.snowflake:snowflake-ingest-sdk:0.9.9`
import $ivy.`net.snowflake:spark-snowflake_2.12:2.8.1-spark_2.4`
import $ivy.`com.outr:hasher_2.12:1.2.2`
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import io.projectglow.Glow
import net.snowflake.spark.snowflake.Utils.SNOWFLAKE_SOURCE_NAME
import com.roundeights.hasher.Implicits._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.to_json


val SNOWFLAKE_SOURCE_NAME = "net.snowflake.spark.snowflake"
val spark = {
      AmmoniteSparkSession.builder()
        .master("local[*]")
        .config("spark.driver.host", "localhost")
//        .config("spark.executor.instances", "4")
        .config("spark.executor.memory", "12g")
        .config("spark.hadoop.io.compression.codecs", "io.projectglow.sql.util.BGZFCodec")
//        .config("spark.sql.execution.useObjectHashAggregateExec", "false")
        .config("spark.sql.files.maxPartitionBytes", "33554432")
//        .config("spark.sql.shuffle.partitions", "100")
//        .config("spark.default.parallelism", "100")
        .getOrCreate()
    }

Glow.register(spark)
import spark.implicits._
