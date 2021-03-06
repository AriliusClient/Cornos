package me.zeroX150.cornos.mixin.packet;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CustomPayloadC2SPacket.class)
public interface CustomPayloadC2SPacketAccessor {
    @Accessor("channel")
    Identifier getChannel();

    @Accessor("channel")
    void setChannel(Identifier newValue);

    @Accessor("data")
    PacketByteBuf getData();

    @Accessor("data")
    void setData(PacketByteBuf newValue);
}
