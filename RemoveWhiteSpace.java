class RemoveWhiteSpace {

    public static void main(String[] args) {

        
        if (args.length == 0) {

            System.out.println("Please provide a string");
            return;
        }

        String str = args[0];

        
        String result = str.replaceAll("\\s", "");

        System.out.println("String after removing white spaces:");
        System.out.println(result);
    }
}