package sr.unasat.library.decorator;

public abstract class SpecialBookDecorator implements SpecialBook {

    protected SpecialBook decoratedSpecial;

    public SpecialBookDecorator(SpecialBook decoratedSpecial){ this.decoratedSpecial = decoratedSpecial;}


}
