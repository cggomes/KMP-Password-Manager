//
//  PasswordView.swift
//  iosApp
//
//  Created by Christian Gomes on 03/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI

struct PasswordView: View {
    
    @EnvironmentObject var passwordViewModel: PasswordViewModel
    
    var body: some View {
        VStack(alignment: .leading) {
            NavigationLink {
                CreatePasswordView()
            } label: {
                plusButton
            }
            searchField
            passwordList
        }
        .frame(maxWidth: .infinity, maxHeight: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/, alignment: .top)
        .padding(16)
    }
    
    var plusButton: some View {
        Image(systemName: "plus.circle")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .frame(width: 24)
            .foregroundColor(.blue)
            .padding(.bottom, 8)
    }
    
    var searchField: some View {
        TextField("Search Password", text: $passwordViewModel.searchTerm)
    }
    
    var passwordList: some View {
        LazyVStack {
            ForEach(passwordViewModel.passwords, id: \.self) { password in
                HStack(spacing: 0) {
                    if password.appLogo.isEmpty {
                        Image(systemName: "key")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 48, height: 48)
                            .padding(.trailing, 8)
                    } else {
                        WebImage(
                            url: URL(string: password.appLogo)
                        ) { result in
                            result.image?.resizable()
                        }
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 48, height: 48)
                        .padding(.trailing, 8)
                    }
                    VStack(alignment: .leading, spacing: 0) {
                        Text(password.title)
                            .bold()
                        Text(password.username)
                            .opacity(0.6)
                    }
                    Spacer()
                    Image(systemName: "ellipsis")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 24)
                        .opacity(0.6)
                }
            }
        }
    }
}

#Preview {
    PasswordView()
        .environmentObject(PasswordViewModel())
}
