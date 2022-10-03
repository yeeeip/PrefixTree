import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode rot = new TreeNode(' ');
    }

    static class TreeNode {
        char value;
        List<TreeNode> children;

        public TreeNode(char value) {
            this.value = value;
        }

        public void insert(String data) {
            if (data.length() == 0) {
                return;
            }
            if (children == null) {
                children = new ArrayList<>();
            }

            char c = data.charAt(0);
            TreeNode child = findNodeByChar(c);
            if (child == null) {
                child = new TreeNode(c);
                children.add(child);
            }
            child.insert(data.substring(1));
        }

        private TreeNode findNodeByChar(char value) {
            for (TreeNode node : children) {
                if (node.value == value) {
                    return node;
                }
            }
            return null;
        }

        private boolean containsString(String str) {
            TreeNode curNode = this;
            for (int i = 0; i < str.length(); i++) {
                curNode = curNode.findNodeByChar(str.charAt(i));
                if (curNode == null) {
                    return false;
                }
            }
            return true;
        }

        public void getAllStrings(String path, List<String> result) {
            if (value != ' ') {
                path = path + value;
            }
            if (children != null) {
                for (TreeNode node : children) {
                    node.getAllStrings(path, result);
                }
            } else {
                result.add(path);
            }
        }
    }
}