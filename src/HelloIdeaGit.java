public class HelloIdeaGit {
    public static void main(String[] args) {
        System.out.println("HelloIdeaGit");
        System.out.println("出现这个问题的最主要原因还是在于本地仓库和远程仓库实际上是独立的两个仓库。假如我之前是直接clone的方式在本地建立起远程github仓库的克隆本地仓库就不会有这问题了。" +
                "git pull origin master –allow-unrelated-histories" );
    }
}
