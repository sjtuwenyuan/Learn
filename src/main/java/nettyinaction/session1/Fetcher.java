package nettyinaction.session1;

public interface Fetcher {
    void fetchData(FetcherCallback callback);
}