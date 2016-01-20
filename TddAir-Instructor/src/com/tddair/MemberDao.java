package com.tddair;

public interface MemberDao {

	boolean contains(String userName);

	void register(String userName, Member member);

	Member lookup(String userName);

}
