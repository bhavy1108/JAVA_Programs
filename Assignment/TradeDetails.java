import java.io.Serializable;

public class TradeDetails implements Serializable
{
  private String symbol;
  private String base;
  private String quote;
  private double bid;
  private double volume;

  public TradeDetails(String sy, String b, String q, double B, double v)
  {
    symbol = sy;
    base = b;
    quote = q;
    bid = B;
    volume = v;
  }

  public String toString()
  {
    return symbol + "\t\t" + base + "-" + quote + " --- " + bid + " --- " + volume;
  }
  public void setBid(double value)
  {
    bid = value;
  }

  public void setVolume(double value)
  {
    volume = value;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public String getBase()
  {
    return base;
  }

  public String getQuote()
  {
    return quote;
  }

  public double getBid()
  {
    return bid;
  }

  public double getVolume()
  {
    return volume;
  }
}
