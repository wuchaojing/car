public class HelloIdeaGit {
    public static void main(String[] args) {
        System.out.println("HelloIdeaGit");
        System.out.println("出现这个问题的最主要原因还是在于本地仓库和远程仓库实际上是独立的两个仓库。假如我之前是直接clone的方式在本地建立起远程github仓库的克隆本地仓库就不会有这问题了。\n" +
                "\n" +
                "查阅了一下资料，发现可以在pull命令后紧接着使用--allow-unrelated-history选项来解决问题（该选项可以合并两个独立启动仓库的历史）。\n" +
                "--------------------- \n" +
                "作者：铁乐与猫 \n" +
                "来源：CSDN \n" +
                "原文：https://blog.csdn.net/u012145252/article/details/80628451 \n" +
                "版权声明：本文为博主原创文章，转载请附上博文链接！");
    }
}
