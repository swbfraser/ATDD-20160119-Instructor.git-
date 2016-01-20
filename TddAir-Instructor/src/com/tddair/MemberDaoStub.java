package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberDaoStub implements MemberDao {
	
	private Map<String, Member> members = new HashMap<>();
	
	@Override
	public boolean contains(String userName) {
		return members.containsKey(userName);
	}

	@Override
	public void register(String userName, Member member) {
		members.put(userName, member);
	}

	@Override
	public Member lookup(String userName) {
		return members.get(userName);
	}

}
