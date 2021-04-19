public class Number {
    private int num;
    private boolean arabic;

    public Number(String s) throws Exception
    {
        try
        {
            num = Integer.parseInt(s);
            arabic = true;
            if (num < 1 || num > 10)
                throw new Exception();
        }
        catch (Exception ex)
        {
            try
            {
                num = parseRomanFrom1To10(s);
                arabic = false;
            }
            catch (Exception exx)
            {
                throw exx;
            }
        }
    }

    public Number(int i, boolean ar)
    {
        num = i;
        arabic = ar;
    }

    private static int parseRomanFrom1To10(String s) throws Exception
    {
        int i;

        if (s.equals("I"))
            i = 1;
        else if (s.equals("II"))
            i = 2;
        else if (s.equals("III"))
            i = 3;
        else if (s.equals("IV"))
            i = 4;
        else if (s.equals("V"))
            i = 5;
        else if (s.equals("VI"))
            i = 6;
        else if (s.equals("VII"))
            i = 7;
        else if (s.equals("VIII"))
            i = 8;
        else if (s.equals("IX"))
            i = 9;
        else if (s.equals("X"))
            i = 10;
        else throw new Exception();

        return i;
    }

    public String toString()
    {
        if (arabic)
            return Integer.toString(num);
        else
            return toRomanView(num);
    }

    private static String toRomanView(int a)
    {
        String ans = "";

        int tens = a/10;
        int units = a % 10;

        if (a == 100)
            return "C";
        if (a == 0)
            return "N";

        // записываем десятки
        if (tens <= 3)  // 0, 1, 2, 3
            for(int i = 1; i <= tens; ++i)
                ans += "X";
        else if (tens == 4)  // 4
            ans += "XL";
        else if (tens <= 8) // 5, 6, 7, 8
        {
            ans += "L";
            for(int i = 6; i <= tens; ++i)
                ans += "X";
        }
        else  // 9
            ans += "XC";

        // записываем единицы
        if (units < 0)
            units = -units;  // т.к. нижеследующий код рассчитан на положительные числа
        if (units <= 3)
            for(int i = 1; i <= units; ++i)
                ans += "I";
        else if (units == 4)
            ans += "IV";
        else if (units <= 8)
        {
            ans += "V";
            for(int i = 6; i <= units; ++i)
                ans += "I";
        }
        else
            ans += "IX";

        if (a < 0)
            ans = "-" + ans; // впереди нужен знак Минус

        return ans;
    }

    public int getNum()
    {
        return num;
    }

    public boolean isArabic()
    {
        return arabic;
    }
}

