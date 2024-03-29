package com.example.demo.connection;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Component;


@Component
public class ConnectionPool {

    private static final String FASTDFS_CONFIG = "conf/fdfs-client.conf";

    /** 空闲的连接池 */
    private LinkedBlockingQueue<StorageClient1> idleConnectionPool = null;

    /** 空闲的忙碌连接池 */
    // private ConcurrentHashMap<StorageClient1, Object> busyConnectionPool = null;

    /** 连接池默认最小连接数 */
    private long minPoolSize = 10;

    /** 连接池默认最大连接数 */
    private long maxPoolSize = 30;

    /** 默认等待时间（单位：秒） */
    private long waitTimes = 200;

    /** fastdfs客户端创建连接默认1次 */
    private static final int COUNT = 1;

    private Object obj = new Object();

    TrackerServer trackerServer = null;

    /**
     * 默认构造方法
     */
    public ConnectionPool()
    {
        /** 初始化连接池 */
        poolInit();

        /** 注册心跳 */
        // HeartBeat beat = new HeartBeat(this);
        // beat.beat();
    }

    public ConnectionPool(long minPoolSize, long maxPoolSize, long waitTimes)
    {
        System.out.println("[线程池构造方法(ConnectionPool)][默认参数：minPoolSize=" + minPoolSize
                + ",maxPoolSize=" + maxPoolSize + ",waitTimes=" + waitTimes + "]");
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.waitTimes = waitTimes;
        /** 初始化连接池 */
        poolInit();
        /** 注册心跳 */
      //  HeartBeat beat = new HeartBeat(this);
       // beat.beat();
    }

    /**
     * @Description: 连接池初始化 (在加载当前ConnectionPool时执行) 1).加载配置文件 2).空闲连接池初始化；
     *               3).创建最小连接数的连接，并放入到空闲连接池；
     */
    private void poolInit()
    {
        try
        {
            /** 加载配置文件 */
            initClientGlobal();
            /** 初始化空闲连接池 */
            idleConnectionPool = new LinkedBlockingQueue<StorageClient1>();
            /** 初始化忙碌连接池 */
            // busyConnectionPool = new ConcurrentHashMap<StorageClient1, Object>();

            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            int flag = 0;
            while (trackerServer == null && flag < 5)
            {
                System.out.println("[创建TrackerServer(createTrackerServer)][第" + flag + "次重建]");
                flag++ ;
                initClientGlobal();
                trackerServer = trackerClient.getConnection();
            }
            // 测试 Tracker活跃情况
            // ProtoCommon.activeTest(trackerServer.getSocket());

            /** 往线程池中添加默认大小的线程 */
            createTrackerServer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("[FASTDFS初始化(init)--异常]");
        }
    }

    /**
     * @Description: 创建TrackerServer,并放入空闲连接池
     */
    public void createTrackerServer()
    {

        System.out.println("[创建TrackerServer(createTrackerServer)]");
        TrackerServer trackerServer = null;

        try
        {

            for (int i = 0; i < minPoolSize; i++ )
            {
                // 把client1添加到连接池
                StorageServer storageServer = null;
                StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
                idleConnectionPool.add(client1);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("[创建TrackerServer(createTrackerServer)][异常：{}]");
        }

    }

    /**
     * @Description: 获取空闲连接 1).在空闲池（idleConnectionPool)中弹出一个连接； 2).把该连接放入忙碌池（busyConnectionPool）中;
     *               3).返回 connection 4).如果没有idle connection, 等待 wait_time秒, and check again
     */
    public StorageClient1 checkout()
    {

        StorageClient1 client1 = idleConnectionPool.poll();

        if (client1 == null)
        {
            if (idleConnectionPool.size() < maxPoolSize)
            {
                createTrackerServer();
                try
                {
                    client1 = idleConnectionPool.poll(waitTimes, TimeUnit.SECONDS);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("[获取空闲连接(checkout)-error][error:获取连接超时:{}]");
                }
            }
        }

        // 添加到忙碌连接池
        // busyConnectionPool.put(client1, obj);
        System.out.println("[获取空闲连接(checkout)][获取空闲连接成功]");
        return client1;
    }

    /**
     * @Description: 释放繁忙连接 1.如果空闲池的连接小于最小连接值，就把当前连接放入idleConnectionPool；
     *               2.如果空闲池的连接等于或大于最小连接值，就把当前释放连接丢弃；
     * @param client1
     *            需释放的连接对象
     */

    public void checkin(StorageClient1 client1)
    {

        System.out.println("[释放当前连接(checkin)]");

        client1 = null;
        if (idleConnectionPool.size() < minPoolSize)
        {
            createTrackerServer();
        }

    }

    private void initClientGlobal()
            throws Exception
    {
        ClientGlobal.init(FASTDFS_CONFIG);
    }

    public LinkedBlockingQueue<StorageClient1> getIdleConnectionPool()
    {
        return idleConnectionPool;
    }

    public long getMinPoolSize()
    {
        return minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize)
    {
        if (minPoolSize != 0)
        {
            this.minPoolSize = minPoolSize;
        }
    }

    public long getMaxPoolSize()
    {
        return maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize)
    {
        if (maxPoolSize != 0)
        {
            this.maxPoolSize = maxPoolSize;
        }
    }

    public long getWaitTimes()
    {
        return waitTimes;
    }

    public void setWaitTimes(int waitTimes)
    {
        if (waitTimes != 0)
        {
            this.waitTimes = waitTimes;
        }
    }
}
