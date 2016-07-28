package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by Wen on 16/7/29.
 */
public class ZK {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 50000, new Watcher() {
            public void process(WatchedEvent event) {

            }
        });
        zooKeeper.create("root", "mydata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create("/root/childone", "childone".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(zooKeeper.getChildren("/root", true));

    }
}
