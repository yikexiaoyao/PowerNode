package demo18;

public abstract class Score {
    private String score;

    private Score(String score) {
        this.score = score;
    }

    private static final Score A = new Score("90-100") {
        @Override
        public void print() {
            System.out.println("A级");
        }
    };
    private static final Score B = new Score("80-89") {
        @Override
        public void print() {
            System.out.println("B级");
        }
    };
    private static final Score C = new Score("70-79") {
        @Override
        public void print() {
            System.out.println("C级");
        }
    };
    private static final Score D = new Score("60-69") {
        @Override
        public void print() {
            System.out.println("D级");
        }
    };
    private static final Score E = new Score("0-59") {
        @Override
        public void print() {
            System.out.println("E级");
        }
    };

    public static Score getA() {
        return A;
    }

    public static Score getB() {
        return B;
    }

    public static Score getC() {
        return C;
    }

    public static Score getD() {
        return D;
    }

    public static Score getE() {
        return E;
    }

    public abstract void print();

    public void printScore() {
        System.out.println(score);
    }
}
