package com.example.enumtest;

public enum ChannelRuleEnum {

    TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    TENCENT("TENCENT",new TencentChannelRule())
    ;
    public String name;
    public GeneralChannelRule channel;

    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }



    ChannelRuleEnum(String name, GeneralChannelRule generalChannelRule) {
        this.name = name;
        this.channel = generalChannelRule;
    }

    public static ChannelRuleEnum match(String name){
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
