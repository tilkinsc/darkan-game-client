package com.jagex;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Login {

    public List aList3388 = new LinkedList();

    boolean aBool3386 = false;

    int anInt3387 = 0;

    int anInt3385 = 0;

    public void method5012() {
        Iterator iterator_2 = this.aList3388.iterator();
        while (iterator_2.hasNext()) {
            Class285 class285_3 = (Class285) iterator_2.next();
            iterator_2.remove();
            Class279.method4969(class285_3);
        }
    }

    void method5013(Class285 class285_1) {
        Transform_Sub1 class521_sub1_3 = class285_1.aTransform_Sub1_3391;
        boolean bool_4 = true;
        EntityNode_Sub5[] arr_5 = class285_1.aTransform_Sub1_3391.boundingBoxPolygons;
        for (int i_6 = 0; i_6 < arr_5.length; i_6++) {
            if (arr_5[i_6].aBool7849) {
                bool_4 = false;
                break;
            }
        }
        if (!bool_4) {
            class285_1.aClass284_3393 = this;
            Class285 class285_7;
            if (this.aBool3386) {
                Iterator iterator_8 = this.aList3388.iterator();
                while (iterator_8.hasNext()) {
                    class285_7 = (Class285) iterator_8.next();
                    if (class521_sub1_3 == class285_7.aTransform_Sub1_3391) {
                        iterator_8.remove();
                        Class279.method4969(class285_7);
                    }
                }
            }
            ListIterator listiterator_9 = this.aList3388.listIterator();
            while (listiterator_9.hasNext()) {
                class285_7 = (Class285) listiterator_9.next();
                if (class521_sub1_3.anInt7969 >= class285_7.aTransform_Sub1_3391.anInt7969) {
                    listiterator_9.previous();
                    listiterator_9.add(class285_1);
                    return;
                }
            }
            this.aList3388.add(class285_1);
        }
    }

    Login() {
        this.aBool3386 = false;
    }

    static final void method5018() {
        if (Class9.loginStage != 2 && Class9.loginStage != 105) {
            try {
                short s_1;
                if (Class9.anInt104 == 0) {
                    s_1 = 250;
                } else {
                    s_1 = 2000;
                }
                if (Class9.socialNetworkLogin && Class9.loginStage >= 65) {
                    s_1 = 6000;
                }
                if (Class9.lobbyStage != 273 || Class9.loginStage != 201 && Class9.anInt106 != 42) {
                    ++Class9.anInt90;
                }
                if (Class9.anInt90 > s_1) {
                    Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                    if (Class9.anInt104 >= 3) {
                        Class9.loginStage = 2;
                        FontRenderer_Sub1.method13784(-5, -1415589664);
                        return;
                    }
                    if (Class9.lobbyStage == 273) {
                        Class159.GAME_CONNECTION_INFO.swap(-541259802);
                    } else {
                        Class448.LOBBY_CONNECTION_INFO.swap(-1978908431);
                    }
                    Class9.anInt90 = 0;
                    ++Class9.anInt104;
                    Class9.loginStage = 18;
                }
                TCPPacket tcpmessage_2;
                int i_3;
                int i_5;
                if (Class9.loginStage == 18) {
                    if (Class9.lobbyStage == 273) {
                        Class9.CURRENT_CONNECTION_CONTEXT.init(SunDefinitions.createAsyncConnection(Class159.GAME_CONNECTION_INFO.createSocket((byte) 91), 15000), Class159.GAME_CONNECTION_INFO.host);
                    } else {
                        Class9.CURRENT_CONNECTION_CONTEXT.init(SunDefinitions.createAsyncConnection(Class448.LOBBY_CONNECTION_INFO.createSocket((byte) 75), 15000), Class448.LOBBY_CONNECTION_INFO.host);
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.clearAllQueuedPackets();
                    tcpmessage_2 = SkyboxDefinitions.method3558((byte) 88);
                    if (Class9.socialNetworkLogin) {
                        tcpmessage_2.buffer.writeByte(OutgoingLoginPacket.INIT_SOCIAL_NETWORK_CONNECTION.id);
                        tcpmessage_2.buffer.writeShort(0);
                        i_3 = tcpmessage_2.buffer.index;
                        tcpmessage_2.buffer.writeInt(727);
                        tcpmessage_2.buffer.writeInt(1);
                        if (Class9.lobbyStage == 273) {
                            tcpmessage_2.buffer.writeByte(client.gameState == 10 ? 1 : 0);
                        }
                        RsByteBuffer rsbytebuffer_4 = Class94.method1587((byte) -40);
                        rsbytebuffer_4.writeByte(Class9.anInt76);
                        rsbytebuffer_4.writeShort((int) (Math.random() * 9.9999999E7D));
                        rsbytebuffer_4.writeByte(Class223.CURRENT_LANGUAGE.getValue());
                        rsbytebuffer_4.writeInt(client.AFFILIATE);
                        for (i_5 = 0; i_5 < 6; i_5++) {
                            rsbytebuffer_4.writeInt((int) (Math.random() * 9.9999999E7D));
                        }
                        rsbytebuffer_4.writeLong(client.aLong7409);
                        rsbytebuffer_4.writeByte(client.CURRENT_GAME.id);
                        rsbytebuffer_4.writeByte((int) (Math.random() * 9.9999999E7D));
                        rsbytebuffer_4.applyRSA();
                        tcpmessage_2.buffer.writeBytes(rsbytebuffer_4.buffer, 0, rsbytebuffer_4.index);
                        tcpmessage_2.buffer.method13281(tcpmessage_2.buffer.index - i_3);
                    } else {
                        tcpmessage_2.buffer.writeByte(OutgoingLoginPacket.INIT_GAME_CONNECTION.id);
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.queuePacket(tcpmessage_2);
                    Class9.CURRENT_CONNECTION_CONTEXT.flush();
                    Class9.loginStage = 35;
                }
                int i_10;
                if (Class9.loginStage == 35) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                    i_10 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                    if (i_10 != 0) {
                        Class9.loginStage = 2;
                        FontRenderer_Sub1.method13784(i_10, -2100127470);
                        Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                        Class361.method6270((byte) 36);
                        return;
                    }
                    if (Class9.socialNetworkLogin) {
                        Class9.loginStage = 46;
                    } else {
                        Class9.loginStage = 80;
                    }
                }
                if (Class9.loginStage == 46) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(2)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 2);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.readUnsignedShort();
                    Class9.loginStage = 57;
                }
                if (Class9.loginStage == 57) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.method13100(Class500.anIntArray5827, 1168221158);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                    String string_18 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.readGJString();
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                    String string_11 = Class361.aClass361_4176.method6253((byte) -35);
                    if (!client.aBool7310 || !Class186.method3082(string_18, 1, string_11)) {
                        PingRequester.method8736(string_18, true, Class393.preferences.currentToolkit.getValue(-778399292) == 5, string_11, client.aBool7158, client.aBool7159, (byte) -110);
                    }
                    Class9.loginStage = 65;
                }
                if (Class9.loginStage == 65) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                    if ((Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff) == 1) {
                        Class9.loginStage = 75;
                    }
                }
                if (Class9.loginStage == 75) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(16)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 16);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 16;
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.method13100(Class500.anIntArray5827, 1118777738);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                    Class9.aLong77 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.readLong();
                    Class9.aLong86 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.readLong();
                    Class9.loginStage = 80;
                }
                RsBitsBuffer rsbitsbuffer_22;
                if (Class9.loginStage == 80) {
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                    Class9.CURRENT_CONNECTION_CONTEXT.clearAllQueuedPackets();
                    tcpmessage_2 = SkyboxDefinitions.method3558((byte) 82);
                    rsbitsbuffer_22 = tcpmessage_2.buffer;
                    int i_6;
                    RsByteBuffer rsbytebuffer_7;
                    OutgoingLoginPacket outgoingloginpacket_20;
                    if (Class9.lobbyStage == 273) {
                        if (Class9.socialNetworkLogin) {
                            outgoingloginpacket_20 = OutgoingLoginPacket.SOCIAL_NETWORK_LOGIN;
                        } else {
                            outgoingloginpacket_20 = OutgoingLoginPacket.GAMELOGIN;
                        }
                        rsbitsbuffer_22.writeByte(outgoingloginpacket_20.id);
                        rsbitsbuffer_22.writeShort(0);
                        i_5 = rsbitsbuffer_22.index;
                        i_6 = rsbitsbuffer_22.index;
                        if (!Class9.socialNetworkLogin) {
                            rsbitsbuffer_22.writeInt(727);
                            rsbitsbuffer_22.writeInt(1);
                            rsbitsbuffer_22.writeByte(client.gameState == 10 ? 1 : 0);
                            i_6 = rsbitsbuffer_22.index;
                            rsbytebuffer_7 = ChatLine.getLoginMod();
                            rsbitsbuffer_22.writeBytes(rsbytebuffer_7.buffer, 0, rsbytebuffer_7.index);
                            i_6 = rsbitsbuffer_22.index;
                            rsbitsbuffer_22.writeByte(Class9.aLong77 == -1L ? 1 : 0);
                            if (Class9.aLong77 == -1L) {
                                rsbitsbuffer_22.writeString(Class9.aString99);
                            } else {
                                rsbitsbuffer_22.writeLong(Class9.aLong77);
                            }
                        }
                        rsbitsbuffer_22.writeByte(Class158.windowedMode());
                        rsbitsbuffer_22.writeShort(Class349.anInt4083);
                        rsbitsbuffer_22.writeShort(Engine.anInt3243 * -969250379);
                        rsbitsbuffer_22.writeByte(Class393.preferences.aPreference_Sub4_8223.method12641(919663007));
                        IdentiKitIndexLoader.method809(rsbitsbuffer_22, 972141670);
                        rsbitsbuffer_22.writeString(client.aString7281);
                        rsbitsbuffer_22.writeInt(client.AFFILIATE);
                        rsbytebuffer_7 = Class393.preferences.encode();
                        rsbitsbuffer_22.writeByte(rsbytebuffer_7.index);
                        rsbitsbuffer_22.writeBytes(rsbytebuffer_7.buffer, 0, rsbytebuffer_7.index);
                        client.aBool7175 = true;
                        RsByteBuffer rsbytebuffer_8 = new RsByteBuffer(Class11.SYSTEM_INFO.method13454());
                        Class11.SYSTEM_INFO.writeMachineInformation(rsbytebuffer_8);
                        rsbitsbuffer_22.writeBytes(rsbytebuffer_8.buffer, 0, rsbytebuffer_8.buffer.length);
                        rsbitsbuffer_22.writeInt(client.anInt7221);
                        rsbitsbuffer_22.writeLong(client.aLong7153);
                        rsbitsbuffer_22.writeString(Class464.aString5555);
                        rsbitsbuffer_22.writeByte(client.aString7156 == null ? 0 : 1);
                        if (client.aString7156 != null) {
                            rsbitsbuffer_22.writeString(client.aString7156);
                        }
                        rsbitsbuffer_22.writeByte(IndexLoaders.NATIVE_LIBRARY_LOADER.method4639() ? 1 : 0);
                        rsbitsbuffer_22.writeByte(client.aBool7310 ? 1 : 0);
                        rsbitsbuffer_22.writeByte(client.aBool7160 ? 1 : 0);
                        rsbitsbuffer_22.writeByte(BASDefinitions.anInt2831);
                        rsbitsbuffer_22.writeInt(client.anInt7163);
                        rsbitsbuffer_22.writeString(client.aString7164);
                        rsbitsbuffer_22.writeByte(Class448.CONNECTION_INFO != null && Class159.GAME_CONNECTION_INFO.worldId == Class448.CONNECTION_INFO.worldId ? 0 : 1);
                        int i_9 = Class159.GAME_CONNECTION_INFO.worldId;
                        rsbitsbuffer_22.writeInt(i_9);
                        QuestDefinitions.writeCRCs(rsbitsbuffer_22, 1259367589);
                        rsbitsbuffer_22.encryptWithXtea(Class500.anIntArray5827, i_6, rsbitsbuffer_22.index);
                        rsbitsbuffer_22.method13281(rsbitsbuffer_22.index - i_5);
                    } else {
                        if (Class9.socialNetworkLogin) {
                            outgoingloginpacket_20 = OutgoingLoginPacket.SOCIAL_NETWORK_LOGIN;
                        } else {
                            outgoingloginpacket_20 = OutgoingLoginPacket.LOBBYLOGIN;
                        }
                        rsbitsbuffer_22.writeByte(outgoingloginpacket_20.id);
                        rsbitsbuffer_22.writeShort(0);
                        i_5 = rsbitsbuffer_22.index;
                        i_6 = rsbitsbuffer_22.index;
                        if (!Class9.socialNetworkLogin) {
                            rsbitsbuffer_22.writeInt(727);
                            rsbitsbuffer_22.writeInt(1);
                            rsbytebuffer_7 = ChatLine.getLoginMod();
                            rsbitsbuffer_22.writeBytes(rsbytebuffer_7.buffer, 0, rsbytebuffer_7.index);
                            i_6 = rsbitsbuffer_22.index;
                            rsbitsbuffer_22.writeByte(Class9.aLong77 == -1L ? 1 : 0);
                            if (Class9.aLong77 == -1L) {
                                rsbitsbuffer_22.writeString(Class9.aString99);
                            } else {
                                rsbitsbuffer_22.writeLong(Class9.aLong77);
                            }
                        }
                        rsbitsbuffer_22.writeByte(client.CURRENT_GAME.id);
                        rsbitsbuffer_22.writeByte(Class223.CURRENT_LANGUAGE.getValue());
                        IdentiKitIndexLoader.method809(rsbitsbuffer_22, -378154884);
                        rsbitsbuffer_22.writeString(client.aString7281);
                        rsbytebuffer_7 = Class393.preferences.encode();
                        rsbitsbuffer_22.writeByte(rsbytebuffer_7.index);
                        rsbitsbuffer_22.writeBytes(rsbytebuffer_7.buffer, 0, rsbytebuffer_7.index);
                        rsbitsbuffer_22.writeString(Class464.aString5555);
                        rsbitsbuffer_22.writeInt(client.AFFILIATE);
                        rsbitsbuffer_22.writeInt(client.anInt7163);
                        rsbitsbuffer_22.writeString(client.aString7164);
                        QuestDefinitions.writeCRCs(rsbitsbuffer_22, 860014211);
                        rsbitsbuffer_22.encryptWithXtea(Class500.anIntArray5827, i_6, rsbitsbuffer_22.index);
                        rsbitsbuffer_22.method13281(rsbitsbuffer_22.index - i_5);
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.queuePacket(tcpmessage_2);
                    Class9.CURRENT_CONNECTION_CONTEXT.flush();
                    Class9.CURRENT_CONNECTION_CONTEXT.isaac = new IsaacCipher(Class500.anIntArray5827);
                    for (int i_12 = 0; i_12 < 4; i_12++) {
                        Class500.anIntArray5827[i_12] += 50;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.aClass432_2295 = new IsaacCipher(Class500.anIntArray5827);
                    new IsaacCipher(Class500.anIntArray5827);
                    Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.setIsaacCipher(Class9.CURRENT_CONNECTION_CONTEXT.aClass432_2295, 1851257503);
                    Class500.anIntArray5827 = null;
                    Class9.loginStage = 97;
                }
                if (Class9.loginStage == 97) {
                    if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                        return;
                    }
                    Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                    i_10 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                    if (i_10 == 21) {
                        Class9.loginStage = 128;
                    } else if (i_10 != 29 && i_10 != 45) {
                        if (i_10 == 1) {
                            Class9.loginStage = 105;
                            FontRenderer_Sub1.method13784(i_10, -1633539224);
                            return;
                        }
                        if (i_10 == 2) {
                            Class9.loginStage = 133;
                        } else {
                            if (i_10 != 15) {
                                if (i_10 == 23 && Class9.anInt104 < 3) {
                                    Class9.anInt90 = 0;
                                    ++Class9.anInt104;
                                    Class9.loginStage = 18;
                                    Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                                    return;
                                } else if (i_10 == 42) {
                                    Class9.loginStage = 201;
                                    FontRenderer_Sub1.method13784(i_10, -1894609821);
                                    return;
                                } else {
                                    if (Class9.aBool74 && !Class9.socialNetworkLogin && Class9.anInt76 != -1 && i_10 == 35) {
                                        Class9.socialNetworkLogin = true;
                                        Class9.anInt90 = 0;
                                        Class9.loginStage = 18;
                                        Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                                    } else {
                                        Class9.loginStage = 2;
                                        FontRenderer_Sub1.method13784(i_10, -476487061);
                                        Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                                        Class361.method6270((byte) 102);
                                    }
                                    return;
                                }
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize = -2;
                            Class9.loginStage = 196;
                        }
                    } else {
                        Class110.anInt1105 = i_10;
                        Class9.loginStage = 180;
                    }
                }
                if (Class9.loginStage == 115) {
                    Class9.CURRENT_CONNECTION_CONTEXT.clearAllQueuedPackets();
                    tcpmessage_2 = SkyboxDefinitions.method3558((byte) 32);
                    rsbitsbuffer_22 = tcpmessage_2.buffer;
                    rsbitsbuffer_22.setIsaacCipher(Class9.CURRENT_CONNECTION_CONTEXT.isaac, 271369997);
                    rsbitsbuffer_22.writeIsaacByte(OutgoingLoginPacket.GAMELOGIN_CONTINUE.id, 264695091);
                    Class9.CURRENT_CONNECTION_CONTEXT.queuePacket(tcpmessage_2);
                    Class9.CURRENT_CONNECTION_CONTEXT.flush();
                    Class9.loginStage = 97;
                } else if (Class9.loginStage == 128) {
                    if (Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                        i_10 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                        Class9.anInt103 = i_10 * 50;
                        Class9.loginStage = 2;
                        FontRenderer_Sub1.method13784(21, 17799798);
                        Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                        Class361.method6270((byte) 74);
                    }
                } else if (Class9.loginStage == 201) {
                    if (Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(2)) {
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 2);
                        Class9.anInt113 = ((Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff) << 8) + (Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[1] & 0xff);
                        Class9.loginStage = 97;
                    }
                } else if (Class9.loginStage == 180) {
                    if (Class110.anInt1105 == 29) {
                        if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                            return;
                        }
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                        Class9.anInt112 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                    } else {
                        if (Class110.anInt1105 != 45) {
                            throw new IllegalStateException();
                        }
                        if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(3)) {
                            return;
                        }
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 3);
                        Class9.anInt112 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                        Class9.anInt94 = (Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[2] & 0xff) + ((Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[1] & 0xff) << 8);
                    }
                    Class9.loginStage = 2;
                    FontRenderer_Sub1.method13784(Class110.anInt1105, -612160283);
                    Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                    Class361.method6270((byte) 89);
                } else if (Class9.loginStage == 133) {
                    if (Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 1);
                        VarNPCMap.anInt1965 = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer[0] & 0xff;
                        Class9.loginStage = 140;
                    }
                } else {
                    RsBitsBuffer buffer;
                    if (Class9.loginStage == 140) {
                        buffer = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer;
                        if (Class9.lobbyStage == 273) {
                            if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(VarNPCMap.anInt1965)) {
                                return;
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(buffer.buffer, 0, VarNPCMap.anInt1965);
                            buffer.index = 0;
                            client.PLAYER_RIGHTS = buffer.readUnsignedByte();
                            client.PLAYER_MOD_LEVEL = buffer.readUnsignedByte();
                            client.USERDETAIL_QUICKCHAT = buffer.readUnsignedByte() == 1;
                            client.VERIFIED_EMAIL_ADDRESS = buffer.readUnsignedByte() == 1;
                            client.aBool7322 = buffer.readUnsignedByte() == 1;
                            client.IS_QUICKCHAT_ONLY = buffer.readUnsignedByte() == 1;
                            client.myPlayerIndex = buffer.readUnsignedShort();
                            client.IS_MEMBER = buffer.readUnsignedByte() == 1;
                            Class504.PLAYER_DOB = buffer.read24BitInteger();
                            client.membersWorld = buffer.readUnsignedByte() == 1;
                            RegionMap.aString3643 = buffer.readString();
                            IndexLoaders.MAP_REGION_DECODER.method4436().method7912(client.membersWorld);
                            IndexLoaders.MAP_REGION_LOADER_THREAD.method6052((short) 2983).method4436().method7912(client.membersWorld);
                            IndexLoaders.ITEM_LOADER.method7148(client.membersWorld);
                            IndexLoaders.NPC_INDEX_LOADER.method6847(client.membersWorld);
                        } else {
                            if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(VarNPCMap.anInt1965)) {
                                return;
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(buffer.buffer, 0, VarNPCMap.anInt1965);
                            buffer.index = 0;
                            client.PLAYER_RIGHTS = buffer.readUnsignedByte();
                            client.PLAYER_MOD_LEVEL = buffer.readUnsignedByte();
                            client.USERDETAIL_QUICKCHAT = buffer.readUnsignedByte() == 1;
                            Class504.PLAYER_DOB = buffer.read24BitInteger();
                            VertexNormal.MY_PLAYER.male = (byte) buffer.readUnsignedByte();
                            client.VERIFIED_EMAIL_ADDRESS = buffer.readUnsignedByte() == 1;
                            client.aBool7322 = buffer.readUnsignedByte() == 1;
                            SongReference.MEMBERSHIP_END = buffer.readLong();
                            Class43.aLong420 = SongReference.MEMBERSHIP_END - Utils.time() - buffer.read5ByteInteger();
                            i_3 = buffer.readUnsignedByte();
                            client.IS_MEMBER = (i_3 & 0x1) != 0;
                            CS2ReturnValue.IS_MEMBER_SUBSCRIPTION = (i_3 & 0x2) != 0;
                            Class354.JCOINS = buffer.readInt();
                            Class469.LOYALTY_ENABLED = buffer.readUnsignedByte() == 1;
                            KeyHoldInputSubscriber.LOYALTY_BALANCE = buffer.readInt();
                            Class115.RECOVERYQUESTIONSSETDATE = buffer.readUnsignedShort();
                            NPCMeshModifier.MESSAGES = buffer.readUnsignedShort();
                            Preference_Sub28.LASTLOGINLDAY = buffer.readUnsignedShort();
                            Class125.LAST_IP_ADDRESS = buffer.readInt();
                            Class119.HOSTNAME_IDENTIFIER = new HostNameIdentifier(Class125.LAST_IP_ADDRESS);
                            (new Thread(Class119.HOSTNAME_IDENTIFIER)).start();
                            InputSubscriberType.EMAIL_STATUS = buffer.readUnsignedByte();
                            SendFinishedCutsceneAction.anInt8307 = buffer.readUnsignedShort();
                            UID192.anInt5357 = buffer.readUnsignedShort();
                            Class464.aBool5556 = buffer.readUnsignedByte() == 1;
                            VertexNormal.MY_PLAYER.displayName = VertexNormal.MY_PLAYER.username = RuntimeException_Sub3.MY_PLAYER_USERNAME = buffer.readGJString();
                            RegionMap.anInt3644 = buffer.readUnsignedByte();
                            Class121.anInt1526 = buffer.readInt();
                            client.aBool7323 = buffer.readUnsignedByte() == 1;
                            Class448.CONNECTION_INFO = new ConnectionInfo();
                            Class448.CONNECTION_INFO.worldId = buffer.readUnsignedShort();
                            if (Class448.CONNECTION_INFO.worldId == 65535) {
                                Class448.CONNECTION_INFO.worldId = -1;
                            }
                            Class448.CONNECTION_INFO.host = buffer.readGJString();
                            if (HDWaterTile.SERVER_ENVIRONMENT != ServerEnvironment.LIVE) {
                                Class448.CONNECTION_INFO.anInt5434 = Class448.CONNECTION_INFO.worldId;
                                Class448.CONNECTION_INFO.anInt5437 = Class448.CONNECTION_INFO.worldId;
                            }
                            if (HDWaterTile.SERVER_ENVIRONMENT != ServerEnvironment.LOCAL && (HDWaterTile.SERVER_ENVIRONMENT != ServerEnvironment.WTQA || client.PLAYER_RIGHTS < 2) && Class159.GAME_CONNECTION_INFO.equals(Class448.aClass450_5420)) {
                                Class274.method4884();
                            }
                        }
                        if ((!client.USERDETAIL_QUICKCHAT || client.aBool7322) && !client.IS_MEMBER) {
                            try {
                                Class441.method7377(IFSubNode.anApplet8065, "unzap", 1103714597);
                            } catch (Throwable throwable_14) {
                            }
                        } else {
                            try {
                                Class441.method7377(IFSubNode.anApplet8065, "zap", 1696424400);
                            } catch (Throwable throwable_16) {
                                if (client.aBool7147) {
                                    try {
                                        IFSubNode.anApplet8065.getAppletContext().showDocument(new URL(IFSubNode.anApplet8065.getCodeBase(), "blank.ws"), "tbi");
                                    } catch (Exception exception_15) {
                                    }
                                }
                            }
                        }
                        if (ServerEnvironment.LIVE == HDWaterTile.SERVER_ENVIRONMENT) {
                            Class361.aClass361_4170.method6257(1331971946);
                        }
                        if (Class9.lobbyStage != 273) {
                            Class9.loginStage = 2;
                            FontRenderer_Sub1.method13784(2, -1482799);
                            Static.method6377();
                            Class365.setGameState(0);
                            Class9.CURRENT_CONNECTION_CONTEXT.currentPacket = null;
                            return;
                        }
                        Class9.loginStage = 167;
                    }
                    if (Class9.loginStage == 167) {
                        if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(3)) {
                            return;
                        }
                        Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 3);
                        Class9.loginStage = 173;
                    }
                    if (Class9.loginStage == 173) {
                        buffer = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer;
                        buffer.index = 0;
                        if (buffer.nextIsSmart()) {
                            if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(1)) {
                                return;
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(buffer.buffer, 3, 1);
                        }
                        i_3 = buffer.readEncryptedSmart();
                        Class9.CURRENT_CONNECTION_CONTEXT.currentPacket = ServerPacket.forId(i_3);
                        Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize = buffer.readUnsignedShort();
                        Class9.loginStage = 156;
                    }
                    if (Class9.loginStage == 156) {
                        if (Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize)) {
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize);
                            Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                            i_10 = Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize;
                            Class9.loginStage = 2;
                            FontRenderer_Sub1.method13784(2, -293580682);
                            Class190.method3152();
                            Class197.method3203(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer, (byte) 87);
                            i_3 = i_10 - Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index;
                            RsBitsBuffer rsbitsbuffer_21 = new RsBitsBuffer(i_3);
                            System.arraycopy(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index, rsbitsbuffer_21.buffer, 0, i_3);
                            Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index += i_3;
                            if (ServerPacket.DYNAMIC_MAP_REGION == Class9.CURRENT_CONNECTION_CONTEXT.currentPacket) {
                                IndexLoaders.MAP_REGION_DECODER.method4499(new Class335(Class256.aClass256_3155, rsbitsbuffer_21), 356381544);
                            } else {
                                IndexLoaders.MAP_REGION_DECODER.method4499(new Class335(Class256.aClass256_3158, rsbitsbuffer_21), 1199163537);
                            }
                            if (Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index != i_10) {
                                throw new RuntimeException(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index + " " + i_10);
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.currentPacket = null;
                        }
                    } else if (Class9.loginStage == 196) {
                        if (Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize == -2) {
                            if (!Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(2)) {
                                return;
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, 2);
                            Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                            Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize = Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.readUnsignedShort();
                        }
                        if (Class9.CURRENT_CONNECTION_CONTEXT.getConnection().available(Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize)) {
                            Class9.CURRENT_CONNECTION_CONTEXT.getConnection().read(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.buffer, 0, Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize);
                            Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index = 0;
                            i_10 = Class9.CURRENT_CONNECTION_CONTEXT.currentPacketSize;
                            Class9.loginStage = 2;
                            FontRenderer_Sub1.method13784(15, 481770271);
                            Class501.method8350();
                            Class197.method3203(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer, (byte) 72);
                            if (Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index != i_10) {
                                throw new RuntimeException(Class9.CURRENT_CONNECTION_CONTEXT.recievedBuffer.index + " " + i_10);
                            }
                            Class9.CURRENT_CONNECTION_CONTEXT.currentPacket = null;
                        }
                    }
                }
            } catch (IOException ioexception_17) {
                Class9.CURRENT_CONNECTION_CONTEXT.method3051();
                if (Class9.anInt104 < 3) {
                    if (Class9.lobbyStage == 273) {
                        Class159.GAME_CONNECTION_INFO.swap(-803067892);
                    } else {
                        Class448.LOBBY_CONNECTION_INFO.swap(1578091404);
                    }
                    Class9.anInt90 = 0;
                    ++Class9.anInt104;
                    Class9.loginStage = 18;
                } else {
                    Class9.loginStage = 2;
                    FontRenderer_Sub1.method13784(-4, -1690933680);
                    Class361.method6270((byte) 123);
                }
            }
        }
    }
}