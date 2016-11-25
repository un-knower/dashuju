package com.laoxiao.mr.weather;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class MyPartitioner extends HashPartitioner<MyKey, DoubleWritable>{

	//执行时间越短越好,每个map task的输出数据都调用此方法
	public int getPartition(MyKey key, DoubleWritable value, int numReduceTasks) {
		return (key.getYear()-1949)%numReduceTasks;
	}
}
