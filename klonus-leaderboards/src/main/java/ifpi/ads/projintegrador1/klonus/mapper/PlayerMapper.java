package ifpi.ads.projintegrador1.klonus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ifpi.ads.projintegrador1.klonus.model.Player;
import ifpi.ads.projintegrador1.klonus.request.PlayerPostResponseBody;
import ifpi.ads.projintegrador1.klonus.request.PlayerPutResponseBody;

@Mapper
public interface PlayerMapper {

	PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
	
	Player playerTo(PlayerPostResponseBody playerPostResponseBody);
	Player playerTo(PlayerPutResponseBody playerPutResponseBody);
}
