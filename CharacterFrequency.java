class CharacterFrequency {

    public static void main(String[] args) {

        
        if (args.length == 0) {

            System.out.println("Please provide a string");
            return;
        }

        String str = args[0].toLowerCase();

        System.out.println("Character Frequencies:");

        for (int i = 0; i < str.length(); i++) {

            int count = 1;

            
            if (str.charAt(i) == ' ')
                continue;

            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {

                    count++;
                }
            }

            
            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {

                if (str.charAt(i) == str.charAt(k)) {

                    alreadyPrinted = true;
                    break;
                }
            }

            if (!alreadyPrinted) {

                System.out.println(str.charAt(i) + " = " + count);
            }
        }
    }
}