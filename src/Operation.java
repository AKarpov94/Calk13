public class Operation {

    private String operationType;
    private Number n1, n2;

    public Operation(String input) throws Exception {

        String[] arguments;

        if (input.indexOf("+") > -1)
        {
            arguments = input.split("\\+");
            operationType = "+";
        }
        else if (input.indexOf("-") > -1)
        {
            arguments = input.split("-");
            operationType = "-";
        }
        else if (input.indexOf("*") > -1)
        {
            arguments = input.split("\\*");
            operationType = "*";
        }
        else if (input.indexOf("/") > -1)
        {
            arguments = input.split("/");
            operationType = "/";
        }
        else
            throw new Exception("Строка не соответствует арифметической операции!");

        if (arguments.length > 2)
            throw new Exception("В строке более одного знака арифметической операции!");

        arguments[0] = arguments[0].trim();
        arguments[1] = arguments[1].trim();

        try
        {
            n1 = new Number(arguments[0]);
        }
        catch (Exception ex)
        {
            throw new Exception("Нет корректного первого числа от 1 до 10!");
        }

        try
        {
            n2 = new Number(arguments[1]);
        }
        catch (Exception ex)
        {
            throw new Exception("Нет корректного второго числа от 1 до 10!");
        }
    }

    public Number calculate() throws Exception
    {
        Number answer;

        if (n1.isArabic()) // Первое число - арабское
        {
            if (n2.isArabic())  // Второе - тоже арабское
            {
                if (operationType.equals("+"))
                    answer = new Number(n1.getNum() + n2.getNum(), true);
                else if (operationType.equals("-"))
                    answer = new Number(n1.getNum() - n2.getNum(), true);
                else if (operationType.equals("*"))
                    answer = new Number(n1.getNum() * n2.getNum(), true);
                else
                    answer = new Number(n1.getNum() / n2.getNum(), true);
            }
            else  // Второе - римское
                throw new Exception("Первое число записано арабскими цифрами, а второе - римскими!");
        }
        else // Первое число - римское
        {
            if (!n2.isArabic()) // Второе - тоже римское
            {
                if (operationType.equals("+"))
                    answer = new Number(n1.getNum() + n2.getNum(), false);
                else if (operationType.equals("-"))
                    answer = new Number(n1.getNum() - n2.getNum(), false);
                else if (operationType.equals("*"))
                    answer = new Number(n1.getNum() * n2.getNum(), false);
                else
                    answer = new Number(n1.getNum() / n2.getNum(), false);
            }
            else // Второе - арабское
                throw new Exception("Первое число записано римскими цифрами, а второе - арабскими!");
        }

        return answer;
    }

}