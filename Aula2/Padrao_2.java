package Aula2;

public class Padrao_2 {

    public static void main(String[] args) {
        Exemplo1 tv = new Exemplo();
        Exemplo4 basicRemote = new Exemplo8(tv);
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();

        Exemplo1 radio = new Exemplo3();
        Exemplo9 advancedRemote = new Exemplo9(radio);
        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.channelUp();
        advancedRemote.mute();
    }
    
}



//----------------------------------------------------



interface Exemplo1 {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}



//----------------------------------------------------



class Exemplo implements Exemplo1 {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) {
            this.volume = 100;
        } else if (percent < 0) {
            this.volume = 0;
        } else {
            this.volume = percent;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}



//----------------------------------------------------



class Exemplo3 implements Exemplo1 {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) {
            this.volume = 100;
        } else if (percent < 0) {
            this.volume = 0;
        } else {
            this.volume = percent;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}



//----------------------------------------------------



class Exemplo4 {
    protected Exemplo1 exemplo;

    public Exemplo4(Exemplo1 exemplo) {
        this.exemplo = exemplo;
    }

    public void togglePower() {
        if (exemplo.isEnabled()) {
            exemplo.disable();
        } else {
            exemplo.enable();
        }
    
    }

    public void volumeDown() {
        exemplo.setVolume(exemplo.getVolume() - 10);
    }

    public void volumeUp() {
        exemplo.setVolume(exemplo.getVolume() + 10);
    }

    public void channelDown() {
        exemplo.setChannel(exemplo.getChannel() - 1);
    }

    public void channelUp() {
        exemplo.setChannel(exemplo.getChannel() + 1);
    }
}



//----------------------------------------------------



class Exemplo8 extends Exemplo4 {
    public Exemplo8(Exemplo1 exemplo) {
        super(exemplo);
    }

    // Métodos adicionais ou implementações específicas...
}



//----------------------------------------------------



class Exemplo9 extends Exemplo4 {
	    public Exemplo9(Exemplo1 exemplo) {
	        super(exemplo);
	    }

	    public void mute() {
	        System.out.println("QUE PADRÃO É ESSE");
	        exemplo.setVolume(0);
	    }
	}

	
	